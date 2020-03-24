package my.learn.pattern.strategy.newimpl;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("classScan")
public class ClassScan {

    public List<Class> getClassAll(String path) throws IOException {
        List<Class> list = new ArrayList<>();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
        Resource[] resources = resolver.getResources(path);
        for (Resource resource : resources) {
            String resourcePath = resource.getURL().toString();
            if (!resourcePath.endsWith(".class")) {
                continue;
            }
            MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
            if (metadataReader == null) {
                continue;
            }
            ClassMetadata classMetadata = metadataReader.getClassMetadata();
            if (classMetadata.isAbstract()) {
                continue;
            }
            String classFullName = classMetadata.getClassName();
            try {
                Class clazz = getClass().getClassLoader().loadClass(classFullName);
                list.add(clazz);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                continue;
            }
        }
        return list;
    }

    public List<Class> getClassByAnnotation(String path, Class cls) throws IOException {
        List<Class> result = new ArrayList<>();
        List<Class> list = getClassAll(path);
        for (Class c : list) {
            if (c.getAnnotation(cls) != null) {
                result.add(c);
                continue;
            }
        }
        return result;
    }

}
