package news.admin.contr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableController {

	@RequestMapping("/table")
	public String table() {
		return "tables_dynamic";
	}
}
