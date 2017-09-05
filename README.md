# Activity Lifecycle

> Activity Lifecycle을 제대로 활용하면 좀 더 쉬워지는 작업들이 있기에 다시 한번 기본적인 것을 공부하며 정리했다.



### 1. Activity Lifecycle

- 말 그대로 Activity의 생성부터 소멸까지의 과정들 그리고 그 과정에서의 특징들을 의미한다.
- Fragment에도 Lifecycle이 있기 때문에 Fragment Lifecycle을 다루지 않겠지만 함께 그림을 비교해보자. 

![](https://ws3.sinaimg.cn/large/006tNc79gy1fj8j8aej7ej30qg0vf12r.jpg)





### 2. 액티비티 회전 시, `onSaveInstanceState()` 와 `onRestoreInstanceState()`메소드 호출

> 아래 그림을 통해 `onSaveInstanceState()`와 `onRestoreInstanceState()` 호출 시점을 알 수 있다. 

![](https://ws4.sinaimg.cn/large/006tNc79gy1fj8nfhf9zdj31h20mywok.jpg)

- 액티비티는 자신의 상태를 **'저장/복원'**하는 것이 가능하다.


- 메소드를 `SharedPreference`보다 가볍게 사용할 수 있다.
- 화면 회전 시, 이전 액티비티의 상태(데이터)를 `Bundle` 에 저장 및 불러와서 다시 데이터 셋팅 가능하다. 만약 해당 메소드 처리를 해주지 않을 경우, 회전할 때마다 기존 액티비티가 갖고 있던 데이터들이 초기화되는 현상이 발생한다. 


```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	// 기존 액티비티의 onPause 후, 호출된다.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
      
      	// Bundle에 data 저장한다. 
        outState.putString("string", data);
    }

    // 액티비티가 회전된 후, onStart 뒤에 호출된다.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
      
      	// 위에서 저장한 data 꺼낸다. 
        data = savedInstanceState.getString("string");
    }
}
```



> 아래 로그화면을 통해 `onSaveInstanceState()`와 `onRestoreInstance()` 메소드 호출 시점을 확인할 수 있다.

![](https://ws4.sinaimg.cn/large/006tNc79gy1fj8mqk6qw2j31hc0u04qp.jpg)

- `onPause` -> `onSaveInstanceState` -> `onStop`-> `onDestroy` -> // 가로화면 종료 // -> `onCreate` -> `onStart` -> `onRestoreInstanceSate` -> `onResume` -> // 세로화면 생성 

>  [출처] 
>  [안드로이드 공식 API - 액티비티 재생성](https://goo.gl/rNrP9a)
>  [안드로이드 공식 API - 액티비티](https://goo.gl/rNrP9a)
>  [개인 블로그](https://goo.gl/BEWwxP)