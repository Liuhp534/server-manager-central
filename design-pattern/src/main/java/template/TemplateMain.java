package template;

import template.entity.PlanTaskAllocationProcessor;

public class TemplateMain {


    public static void main(String[] args) {
        fun1();
    }


    private static void fun1() {
        PlanTaskAllocationProcessor processor = new PlanTaskAllocationProcessor();
        processor.configHandlerThreadPool();
        processor.configTaskPageSize();
        processor.templateMethod();
    }
}
