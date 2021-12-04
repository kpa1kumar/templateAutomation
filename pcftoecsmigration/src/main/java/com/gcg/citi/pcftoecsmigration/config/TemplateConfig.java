package com.gcg.citi.pcftoecsmigration.config;

import freemarker.core.ParseException;
import freemarker.template.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

@Slf4j
public class TemplateConfig {
  public static Template getTemplate(String templatePath, String templateName) throws Exception {

    Template template = null;
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
    cfg.setDefaultEncoding("UTF-8");
    cfg.setLocale(Locale.US);
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    try {
      cfg.setDirectoryForTemplateLoading(new File(templatePath));
      template = cfg.getTemplate(templateName);
      log.info("Template path is : "+ templatePath + File.separator + templateName);
    } catch (TemplateNotFoundException | MalformedTemplateNameException e) {
      log.error("Template doesn't exist :", e);
      throw new RuntimeException("ErrorDetails.NR_EDI_C_1000");
    } catch (ParseException e) {
      log.error("Error exists in the template :", templateName);
      throw new RuntimeException("ErrorDetails.NR_EDI_C_1002");
    } catch (IOException e) {
      log.error("Unable to access the template", e);
      throw new RuntimeException("ErrorDetails.NR_EDI_C_1003");
    }
    return template;
  }
}
