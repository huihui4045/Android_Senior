### 标题
```java

 @Override
    public List<ItemBean> getDatas() {
        List<ItemBean> list = new ArrayList<>();
        list.add(new ItemBean("间隔线", new MyDashView(getApplicationContext())));
        list.add(new ItemBean("Paint基本用法", new MyView(getApplicationContext())));
        list.add(new ItemBean("颜色矩阵", new FilterView(getApplicationContext())));
        list.add(new ItemBean("自定义进度条", new CircleProgressView(getApplicationContext())));
        return list;
    }

```

![]()