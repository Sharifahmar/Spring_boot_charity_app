package com.ecomm.akhtar.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.ecomm.akhtar.exception.CustomException;
import com.lowagie.text.DocumentException;

@Service
public class PdfGenerateUtils {

	public static final Logger logger = LogManager.getLogger(PdfGenerateUtils.class);

	@Autowired
	private TemplateEngine templateEngine;

	public void createPdf(String templateName, Map<String, Object> map) throws IOException, DocumentException {
		Context ctx = new Context();
		ctx.setVariables(map);
		String processedHtml = templateEngine.process(templateName, ctx);
		FileOutputStream os = null;
		String fileName = UUID.randomUUID().toString();
		try {
			final File outputFile = File.createTempFile(fileName, ".pdf", new File(System.getProperty("user.home")));
			os = new FileOutputStream(outputFile);
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(processedHtml);
			renderer.layout();
			renderer.createPDF(os, false);
			renderer.finishPDF();
			logger.info("PDF created successfully with file name {}.pdf", fileName);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error("Exception Occurs while creating file ", e.getMessage());
				}
			}
		}
	}
}
