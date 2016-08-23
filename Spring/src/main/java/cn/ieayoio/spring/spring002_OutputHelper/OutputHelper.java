package cn.ieayoio.spring.spring002_OutputHelper;

/**
 * Created by ieayoio on 16-8-23.
 */
public class OutputHelper
{
    IOutputGenerator outputGenerator222;

    public void generateOutput(){
        outputGenerator222.generateOutput();
    }

    public void setOutputGenerator(IOutputGenerator outputGenerator){
        this.outputGenerator222 = outputGenerator;
    }
}