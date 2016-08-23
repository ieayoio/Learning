package cn.ieayoio.spring.spring005_DI_Setter;

/**
 * Created by ieayoio on 16-8-23.
 */
public class OutputHelper {
    IOutputGenerator outputGenerator;

    public void generateOutput() {
        outputGenerator.generateOutput();
    }

    //DI via setter method
    public void setOutputGenerator(IOutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }
}
