package pri.liyang.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/second")
public interface SecondService {

    @GetMapping("/executeSecond")
    String getSecondValueLcn(@RequestParam("id") Long id, @RequestParam("cash") Long cash);

    @GetMapping("/executeSecondTcc")
    String getSecondValueTcc(@RequestParam("param") String param);

}
