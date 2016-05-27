package com.f6car.common.query;

import java.util.List;

public interface Sortable {

    List<Sort> getSorts();

    void addSort(Sort sort);

}
