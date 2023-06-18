package builder.demo2;

public class Phone {

    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    private Phone(Builder builder) {
//        将该形参的静态变量复制给实例变量
        cpu = builder.cpu;
        screen = builder.screen;
        memory = builder.memory;
        mainboard = builder.mainboard;
    }


    //   通过构建者来创建对象:    静态内部类可以访问外部的对象
    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder() {
        }

        public Builder cpu(String val) {
            this.cpu = val;
            return this;            // return this后可以重新获得该对象，用于填充新属性（例如mvc和security中用到的）
        }

        public Builder screen(String val) {
            this.screen = screen;
            return this;
        }

        public Builder memory(String val) {
            this.memory = val;
            return this;
        }

        public Builder mainboard(String val) {
            this.mainboard = val;
            return this;
        }
//        链式编程最后打包
        public Phone build(){
            return new Phone(this);   // 将当前静态内部类作为对象传给Phone对象
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                '}';
    }
}
