package com.f6car.aspect;

import com.f6car.common.query.BaseSo;
import com.f6car.common.query.Sort;
import com.github.pagehelper.PageHelper;
import com.google.common.base.CaseFormat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by qixiaobo on 16/5/19.
 */
@Component
@Aspect
public class PageAspect {

    private static final CaseFormat FROM_FORMAT = CaseFormat.LOWER_CAMEL;
    private static final CaseFormat TO_FORMAT = CaseFormat.LOWER_UNDERSCORE;

    @Before(value = "execution(* com.f6car.mapper.base.BaseRepository+.*(com.f6car.common.query.BaseSo)) && args(so)")
    public void pageIntercept(JoinPoint jp, BaseSo so) {
        PageHelper.startPage(so.getCurrentPage(), so.getPageSize());
        if (so.getSorts().size() > 0) {
            for (Sort sort : so.getSorts()) {
                PageHelper.orderBy(getSort(sort));
            }
        }

    }

    private String getSort(Sort sort) {
        String dbColumn = FROM_FORMAT.to(TO_FORMAT, sort.getSortKey());
        return sort.getSortDir() == null ? dbColumn : dbColumn + " " + sort.getSortDir();
    }
}
