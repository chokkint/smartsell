package com.ivantee.smartsell.manager;


import com.ivantee.smartsell.base.BaseFragment;
import com.ivantee.smartsell.model.QDItemDescription;

import java.util.HashMap;
import java.util.Map;

class QDWidgetContainer {
  private static QDWidgetContainer sInstance = new QDWidgetContainer();

  private Map<Class<? extends BaseFragment>, QDItemDescription> mWidgets;

  private QDWidgetContainer() {
    mWidgets = new HashMap<>();

  }

  public static QDWidgetContainer getInstance() {
    return sInstance;
  }

  public QDItemDescription get(Class<? extends BaseFragment> fragment) {
    return mWidgets.get(fragment);
  }
}
