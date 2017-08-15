### 初始化
1. 定义一个复杂对象 Product
2. 定义 Product 各个部分的创建接口 Builder
3. 定义一个使用 Builder 接口并返回 Product 对象的对象 Director

### 使用
1. 定义一个 Product 的子类 Instance
2. 定义一个实现 Builder 接口并返回 Product 对象的对象 InstanceBuilder
3. 创建一个 InstanceBuilder 并作为参数传入 Director 即可