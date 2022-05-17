import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// @Controller +　@ResponseBody
//@ResponseBody返回的对象，转换为 JSON 格式，通过 response 对象返回给客户端。
@RestController
@RequestMapping("/travelItem")
public class TravelItemController {

    // dubbo远程调用服务
    @Reference
    TravelItemService travelItemService;
}
