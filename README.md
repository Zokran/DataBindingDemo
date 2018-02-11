<h3>DataBinding

1. 如何使用DataBinding加载图片

定义一个静态方法 并使用BindingAdapter注解
```java
public class Utils {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }
}
```
然后在布局文件中使用
```
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>

        <variable
            name="url"
            type="String" />

    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        
        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:imageUrl="@{url}" />

    </LinearLayout>
    
</layout>

```

2.如何给EditText添加TextWatcher

在代码中定义三个变量

```
  private TextViewBindingAdapter.BeforeTextChanged beforeTextChanged = new TextViewBindingAdapter.BeforeTextChanged() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             //do something
         }
     };
 
     private TextViewBindingAdapter.OnTextChanged onTextChanged = new TextViewBindingAdapter.OnTextChanged() {
         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             //do something
         }
     };
 
     private TextViewBindingAdapter.AfterTextChanged afterTextChanged = new TextViewBindingAdapter.AfterTextChanged() {
         @Override
         public void afterTextChanged(Editable s) {
             //do something
         }
     };
     
     binding.setBeforeTextChanged(beforeTextChanged);
     binding.setOnTextChanged(onTextChanged);
     binding.setAfterTextChanged(afterTextChanged);
     
```

布局文件
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>

        <variable
            name="beforeTextChanged"
            type="android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged" />

        <variable
            name="onTextChanged"
            type="android.databinding.adapters.TextViewBindingAdapter.OnTextChanged" />

        <variable
            name="afterTextChanged"
            type="android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged" />

    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        
        <EditText
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:afterTextChanged="@{afterTextChanged}"
            android:beforeTextChanged="@{beforeTextChanged}"
            android:onTextChanged="@{onTextChanged}" />

    </LinearLayout>
</layout>

```
3. 双向绑定 
```
private ObservableField<String> twoWayBind = new ObservableField<>("双向绑定");
binding.setTwoWayBind(twoWayBind);
//当EditText文字变化时，调用这个方法
public void testTwoWayBind(View view) {
        Toast.makeText(this, twoWayBind.get(), Toast.LENGTH_SHORT).show();
    }

```
 xml文件
```
 <variable
            name="twoWayBind"
            type="android.databinding.ObservableField&lt;String>" />
            
  <EditText
             android:id="@+id/et_two_way_bind"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:gravity="center"
             android:text="@={twoWayBind}" />
 
         <Button
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:onClick="testTwoWayBind"
             android:text="输出EditText 的文字变化后，towWayBind的值" />
```

注意写法的改变 是**@=**
```
android:text="@={twoWayBind}" 
```
4. @BindingConversion注解的使用

布局文件
```
 <variable
    name="time"
    type="java.util.Date" />
            
 <TextView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="@{time}"
      tools:text="使用convert" />
      
```
java代码
```
 bindBinding.setTime(new Date());
```
`@BindingConversion` 标记的方法调用时机：
Android中的每个xml中的属性其实都对应着相应的java方法的，
如果在xml中设置的属性值的类型与对应的Java方法的参数类型不符，
这时 dataBinding就会去寻找可以让属性值转换为正确类型的方法，
而寻找的根据就是所有被@BindingConversion注解标记的方法
