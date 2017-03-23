package org.moss.charactersheet;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class CharacterSheet {

	public static void main(String[] args)
    {
    	try {
    	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    	        if ("Nimbus".equals(info.getName())) {
    	            UIManager.setLookAndFeel(info.getClassName());
    	            break;
    	        }
    	    }

			ConfigurableApplicationContext context = new SpringApplicationBuilder(CharacterSheet.class).headless(false).run(args);
			SheetFrame appFrame = context.getBean(SheetFrame.class);
			appFrame.setVisible(true);

    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
}
