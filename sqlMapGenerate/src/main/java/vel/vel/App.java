package vel.vel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    
    {
       // VelocityEngine  ve = new  VelocityEngine();
        
        Properties prop = new Properties();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("conf/default.properties");
        prop.load(is);
        
        Velocity.init(prop);
        //Template template = Velocity.getTemplate("Template/index.vm");
        VelocityContext  context = new VelocityContext();
        context.put("user", "zhangsan");
      //  StringWriter writer  = new StringWriter();
       // template.merge(context, writer);
       // System.out.println(writer.toString());
        
        InputStream read = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/index.vm");
        String path = System.getProperty("user.dir")+File.separator;
        //
       Writer w =  new OutputStreamWriter(new FileOutputStream(new File(path+"sqlMap"+File.separator+"user.xml")));
        Velocity.evaluate(context,w , "", new InputStreamReader(read));
        w.close();
      
        
        
    }
}
