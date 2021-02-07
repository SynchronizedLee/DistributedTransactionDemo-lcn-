package pri.liyang.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "provider2")
@Qualifier("secondRemoteService")
public interface SecondRemoteService extends SecondService {

}
