import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

// Dubbo 服务
@Service(interfaceClass = TravelItemService.class)
// 所有方法都会开开启事务
@Transactional
public class TravelItemServiceImpl implements TravelItemService{

    @Autowired
    TravelItemDao travelItemDao;
}
