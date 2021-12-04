package com.gcg.citi.pcftoecsmigration;

import com.gcg.citi.pcftoecsmigration.config.TemplateConfig;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Test {
  public static void main(String[] args) throws Exception {

    Map<String, String> map = new HashMap<>();
    map.put("name","Pavankumar");

    Template template =
        TemplateConfig.getTemplate(
            "C:\\code\\pcftoecsmigration\\src\\main\\resources\\templates", "Test.ftl");

    Writer console = new OutputStreamWriter(System.out);
    try {
      template.process(map, console);
    } catch (TemplateException e) {
      log.error("Template Exception occurred while processing data: ", e);
      throw new RuntimeException("ErrorDetails.NR_EDI_C_1005");
    } catch (IOException e) {
      log.error("Exception occurred when trying to write data to the output : ", e);
      throw new RuntimeException("ErrorDetails.NR_EDI_C_1006");
    }

    /*Writer fileWriter;
    try {
    	fileWriter = new FileWriter(new File("./output/po_output.xml"));
    	template.process(map, fileWriter);
    } catch (TemplateException e) {
    	LOG.error("Template Exception occured while processing data: ", e);
    	throw new EdiException(ErrorDetails.NR_EDI_C_1005);
    } catch (IOException e) {
    	LOG.error("Exception occured when trying to write data to the output : ", e);
    	throw new EdiException(ErrorDetails.NR_EDI_C_1006);
    }*/
  }
}
