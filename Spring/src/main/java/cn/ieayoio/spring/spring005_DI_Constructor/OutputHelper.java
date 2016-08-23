package cn.ieayoio.spring.spring005_DI_Constructor;

/**
 * Created by ieayoio on 16-8-23.
 */
public class OutputHelper {
    IOutputGenerator outputGenerator;

    public void generateOutput() {
        outputGenerator.generateOutput();
    }

    //DI via constructor
    public OutputHelper(IOutputGenerator outputGenerator){
        this.outputGenerator = outputGenerator;
    }

}