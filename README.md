# 目录
- [目录](#目录)
- [实验一](#实验一)
    - [新建空项目“Hello world！”](#新建空项目hello-world)
    - [代码](#代码)
- [实验二](#实验二)
  - [题目2.1](#题目21)
  - [题目2.2](#题目22)
  - [题目2.3](#题目23)
  - [题目2.4](#题目24)
- [实验三](#实验三)
  - [题目3.1](#题目31)
  - [题目3.2](#题目32)
  - [题目3.3](#题目33)
  - [题目3.4](#题目34)
- [题目NotePad](#题目notepad)
- [一、基本UI页面的编写](#一基本ui页面的编写)
  - [1.1主页面](#11主页面)
  - [1.2记事页面](#12记事页面)
  - [1.3录音页面](#13录音页面)
  - [1.4手写板页面](#14手写板页面)
  - [1.5录音详情页面](#15录音详情页面)
  - [1.6图片详情页面](#16图片详情页面)
  - [1.7录像详情页面](#17录像详情页面)
- [二、数据的保存、查询、修改和读取功能](#二数据的保存查询修改和读取功能)
  - [2.1 数据库的建立](#21-数据库的建立)
  - [2.2 数据库字段的设置](#22-数据库字段的设置)
  - [2.4 记事的增加](#24-记事的增加)
  - [2.5 记事的查找](#25-记事的查找)
  - [2.6 记事的删除](#26-记事的删除)
  - [2.7 记事的修改](#27-记事的修改)
- [三、多媒体功能的应用](#三多媒体功能的应用)
  - [3.1 文字](#31-文字)
  - [3.2 录音](#32-录音)
  - [3.3 拍照](#33-拍照)
  - [3.4 视频](#34-视频)
  - [3.5 手写板](#35-手写板)
- [notepad功能展示](#notepad功能展示)
  - [首页、时间戳](#首页时间戳)
  - [录音](#录音)
  - [录音2](#录音2)
  - [录像](#录像)
  - [照相](#照相)
  - [照相2](#照相2)
  - [手写](#手写)
  - [搜索](#搜索)

# 实验一
### 新建空项目“Hello world！”
![image](https://github.com/WananGQ/Android2022/blob/main/sy1/imge/QQ%E6%88%AA%E5%9B%BE20221028122520.png)
### 代码
```
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
# 实验二
## 题目2.1
![image](https://github.com/WananGQ/Android2022/blob/main/sy2_1/image/%E6%89%8B%E6%9C%BA.png)
## 题目2.2
![image](https://github.com/WananGQ/Android2022/blob/main/sy2_2/imge/QQ%E6%88%AA%E5%9B%BE20221013060201.png)
## 题目2.3
![image](https://github.com/WananGQ/Android2022/blob/main/sy2_3/imge/QQ%E6%88%AA%E5%9B%BE20221013182217.png)
## 题目2.4
![image](https://github.com/WananGQ/Android2022/blob/main/sy2_4/Imge/QQ%E6%88%AA%E5%9B%BE20221013192344.png)
# 实验三
## 题目3.1
![image](https://github.com/WananGQ/Android2022/blob/main/sy3_1/image/%E8%BF%90%E8%A1%8C.png)
## 题目3.2
![image](https://github.com/WananGQ/Android2022/blob/main/sy3_2/image/%E8%BF%90%E8%A1%8C.png)
## 题目3.3
![image](https://github.com/WananGQ/Android2022/blob/main/sy3_3/image/%E8%BF%90%E8%A1%8C.png)
## 题目3.4
![image](https://github.com/WananGQ/Android2022/blob/main/sy3_4/image/%E8%BF%90%E8%A1%8C.png)
# 题目NotePad

# 一、基本UI页面的编写

## 1.1主页面
主页面主要是展现所有笔记的缩略图以及跳转到新增记事页面。
对于展现笔记的缩略图，用listview来动态获取数据库中存的信息。
在右下角设置图标，点击后即可跳转到记事页面。
对于listview中的每一项笔记，都展现题目和创建日期，方便使用者对所有笔记做出区分。
xml的基本布局代码：

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%871.png)

MainActivity中的初始化

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%872.png)

给右下角图标添加点击事件，点击后跳转到新增记事页面。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%873.png)

## 1.2记事页面
记事页面由上、中、下三个部分构成。
上部分为该页面的导航栏，左边为返回上一级的图标，右边为保存本记事的图标，中间可以输入该记事的标题。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%874.png)

中间部分为记事的编辑框部分，可以在这里输入五种内容，分别为文字、录音、视频、照相和手写。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%875.png)

下部分为多媒体的选项，点击图标可以插入对应的内容。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%876.png)

在中间部分的编辑框中，新写了一个类继承EditText，对每一行的文字都添加了下划线，方便区分，使得页面更加美观。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%877.png)

## 1.3录音页面
录音页面是在记事页面后点击下方的录音图标跳转后的页面。在该页面可以进行录音，试听录音，保存录音。该页面也是上中下三部分。上部分主要是导航栏，有返回和确定两个按钮，点击返回可以返回上一级页面，点击确定可以保存数据。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%878.png)

中间部分为录音图标和计时器，点击录音图标可以试听录音和停止试听录音。下面的计时器是动态显示的，随着录音的试听动态变化。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%879.png)

下部分为录音、停止录音的按钮。初次点击按钮后，开始录音；正在录音时，点击该按钮录音停止并且自动保存到本地。如果再次点击该按钮，将重新进行录音并且替换上次保存的文件，这样每次不会保存重复的文件。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8710.png)

## 1.4手写板页面
手写板的页面有两部分构成，上部分为导航栏，有返回和确定两个按钮。点击返回可以返回到编辑记事页面，点击确定可以将图片保存到本地并且展现到记事页面上。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8711.png)

下部分为手写的主要区域，可以设置画笔的颜色、粗细和橡皮擦。橡皮擦实际上就是白色颜色的画笔。还设置了imgview用来展现用户的轨迹和图像。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8712.png)

## 1.5录音详情页面
录音详情页面是在编辑记事里插入录音后，会将录音图标展现到页面上，再次点击该图标就可以进入录音详情，播放录音。
导航栏只有返回按钮，设立在左上角，点击该按钮可以返回编辑记事页面。中间为录音图标和动态更新的计时器。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8713.png)

## 1.6图片详情页面
图片详情页面是在编辑记事页面插入图片后，再点击该图片就可以查看图片的放大图。导航栏为返回上一级，下面添加了imgview用来展现图片。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8714.png)

## 1.7录像详情页面
在编辑记事页面点击录像后，进入此页面。点击录像可以调用系统相机进行拍照。下面的VideoView，可以展现刚刚录制的视频。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8715.png)

# 二、数据的保存、查询、修改和读取功能
## 2.1 数据库的建立
采用room框架建立数据库，并且使用了单例模式进行设计，这样确保只有一个对象被创建。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8716.png)

## 2.2 数据库字段的设置
考虑一个记事本主要包含的内容，无异于标题、内容和创建时间，所以选择这三个作为数据库中表Data的字段。为了区分不同的笔记，还应当增加id自增使得其是Data的主键。注意多媒体的东西，如录音、图片等等都是将路径保存到数据库里，等编辑记事的时候再将其从路径中取出来并且展现在页面上。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8717.png)

##2.3 数据接口的设立
分析记事本的需求得到应当有以下几种操作：增加记事，删除全部记事，查询所有记事，按id删除记事，按id查找记事，更新记事。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8718.png)

## 2.4 记事的增加
在编辑记事页面，点击右上角的图标可以将记事保存到数据库。添加时，获取编辑页面的标题、内容和系统的时间。对于图片、录音等多媒体而言，保存的是他们在手机上存储的路径。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8719.png)


## 2.5 记事的查找
在主页面上，应当显示数据库中所有笔记的列表视图，这就用到了数据库的查询。
![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8720.png)

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8721.png)

## 2.6 记事的删除
给列表中的每一项都添加长按事件，长按后弹出选择框，可以选择删除或修改。选择删除的话，根据id查找到该项，删除。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8722.png)

## 2.7 记事的修改
点击修改后也进入编辑记事页面，并且应当将原先的记事内容展现在页面上。那么新增记事和修改记事都是进入编辑记事页面，可以在intent对象里多增加一个参数来表示是编辑还是新增，并且传一下编辑对象的id值，这样进入编辑页面的时候就可以将记事内容展现在页面上了。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8723.png)

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8724.png)

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8725.png)

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8726.png)



# 三、多媒体功能的应用

## 3.1 文字
正常的EditText就可以输入文字，设置监听事件就可以进行监听和保存。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8727.png)

## 3.2 录音
录音使用的是安卓自带的MediaRecorder和MediaPlayer。在点击录音的时候，调用new MediaRecorder()并且进行初始化设置。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8728.png)

在点击试听的时候，调用MediaPlayer进行播放。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8729.png)

这样就完成了基本录音功能的实现。接下来实现各个图标的点击事件和计时器的自动播放。
在试听录音、播放录音或进行录音时，下面的计时器是在变化的。对此计时器，开辟一个单独的线程来处理。每次动态的设置时间的变化，并且修改textview的值。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8730.png)

对于麦克风的图标来说，如果当前未录音，点击应当提示用户先录音。所以可以设一个变量来标记用户是否已经开始录音。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8731.png)

如果已经有录音文件的话，应当区分现在点击是播放录音和暂停播放录音。设置变量isPlaying用来区分。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8732.png)

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8733.png)

点击返回后，删除已经保存的录音文件，返回编辑页面。点击确定后，将路径返回给编辑页面。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8734.png)

## 3.3 拍照
编辑页面点击拍照后，调用系统自带的相机进行拍照，跳转到系统相机，拍照后保存在本地图库，并且将路径返回。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8735.png)

重写onActivityResult方法，记录不同的requstcode对应不同的操作。用Uri存取回的数据。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8736.png)

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8737.png)

查看图片时，将图片的路径放入intent中，跳转到查看图片页面后，利用bitmap加载路径中的图片，放到imgview中。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8738.png)

## 3.4 视频
点击录像跳转到对应的录像类

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8739.png)

在录像页面中点击录像可以调用系统相机进行录像

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8740.png)

系统相机录像完成后，将对应的文件实例化到播放器上。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8741.png)

## 3.5 手写板
编辑记事页面点击手写后，进入手写板页面。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8742.png)

给手写板的imgview设置触摸事件，记录绘制的路径。每次按下时记录点击位置，移动时获取当前位置并且绘制直线，结束时将重点设置为下一次的起点。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8743.png)

点击设置颜色按钮可以设置画笔的颜色，添加dialog对话框来提供可选择的颜色。用户选择之后将修改paint的color属性。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8744.png)

点击设置宽度按钮可以设置画笔的粗细，添加dialog对话框来提供可选择的宽度。用户选择之后修改paint的width属性。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8745.png)

由于底色是白色，所以橡皮擦实际上就是白色的画笔。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8746.png)

保存图片的时候，可以先将图片保存到Bundle里，再将Bundle放到intent对象里。返回上一级页面。

![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%9B%BE%E7%89%8747.png)

# notepad功能展示

## 首页、时间戳
![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E9%A6%96%E9%A1%B5.png)
## 录音
![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%BD%95%E9%9F%B3.png)
## 录音2
![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%BD%95%E9%9F%B31.png)
## 录像
![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E5%BD%95%E5%83%8F.png)
## 照相
![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E7%85%A7%E7%9B%B81.png)
## 照相2
![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E7%85%A7%E7%9B%B82.png)
## 手写
![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E6%89%8B%E5%86%99.png)
## 搜索
![image](https://github.com/WananGQ/Android2022/blob/main/notepad/imge/%E6%90%9C%E7%B4%A2.png)
