package pri.liyang.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/first")
public interface FirstService {

    @GetMapping("/executeFirst")
    String getFirstValueLcn(@RequestParam("id") Long id, @RequestParam("cash") Long cash);

    @GetMapping("/executeFirstTcc")
    String getFirstValueTcc(@RequestParam("param") String param);

}
