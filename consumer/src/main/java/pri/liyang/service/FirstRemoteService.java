package pri.liyang.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "provider1")
@Qualifier("firstRemoteService")
public interface FirstRemoteService extends FirstService {

}
