package soa.web;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SearchController {

	@Autowired
	  private ProducerTemplate producerTemplate;

	@RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/search")
    @ResponseBody
	public Object search(@RequestParam("q") String q) {
	    	String[] palabras = q.split(" ");
	    	Map<String, Object> headers = new HashMap<String, Object>();
				String keyWords="";
				String max=null;
				for (int i=0; i<palabras.length;i++){
					if(palabras[i].contains("max:")){
						max=palabras[i].split(":")[1];
					}
					else{
					keyWords+=palabras[i];
					}
				}
	    	headers.put("CamelTwitterKeywords", keyWords);
				if(max!=null){
					headers.put("CamelTwitterCount",max);
				}
    	return producerTemplate.requestBodyAndHeaders("direct:search", "", headers);
    }
}
