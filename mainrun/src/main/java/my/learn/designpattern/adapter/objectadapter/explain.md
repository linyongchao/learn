1. Source类中有一个方法，待适配
2. 目标接口Targetable
3. 通过Adapter类，将Source的功能扩展到Targetable里

ps1: 适配的方法名没有限制  
ps2: 实现方式并不继承Source类，而是持有Source类的实例