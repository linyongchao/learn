package my.learn.utils.app;

/**
 * APP解析结果
 * 
 * @author lin
 * @date 2017年7月26日 下午7:45:19
 */
public class AppParse {
	/**
	 * APP名称
	 */
	private String name;
	/**
	 * 平台，1：Android；2：iOS
	 */
	private String plat;
	/**
	 * versionName
	 */
	private String versionName;
	/**
	 * versionCode
	 */
	private String versionCode;
	/**
	 * 是否强制升级
	 */
	private Integer forceUpgrade;
	/**
	 * package
	 */
	private String pkg;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 大小
	 */
	private Long size;
	/**
	 * 最小系统要求
	 */
	private String minVersion;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public Integer getForceUpgrade() {
		return forceUpgrade;
	}

	public void setForceUpgrade(Integer forceUpgrade) {
		this.forceUpgrade = forceUpgrade;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getMinVersion() {
		return minVersion;
	}

	public void setMinVersion(String minVersion) {
		this.minVersion = minVersion;
	}

	@Override
	public String toString() {
		return "AppParse [name=" + name + ", plat=" + plat + ", versionName=" + versionName + ", versionCode="
				+ versionCode + ", forceUpgrade=" + forceUpgrade + ", pkg=" + pkg + ", path=" + path + ", size=" + size
				+ ", minVersion=" + minVersion + "]";
	}

}
