package io.github.t45k.trials.duplicatedBean;

import org.springframework.stereotype.Service;

@Service("service1") // 実装クラスで直接Bean名を指定する
public class DuplicatedBeanService implements IDuplicatedBeanService {
}
