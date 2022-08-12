module module.three {
    exports com.mkdirjava.module.three;
    requires module.two;
    // For some reason the maven compiler plugin does not like this
//    provides com.mkdirjava.module.two.IService with com.mkdirjava.module.three;
}