# jrc
j remote config 一个远程配置的开源项目

配置会存放在远程，项目中基本上可以做到没有任何配置文件，
同时，配置文件也会备份存在服务器的硬盘上面，防止jrc-server宕机，导致应用程序无法启动。
在jrc-server存活的时候，会大jrc-server中取配置文件，如果jrc-server宕机，会从硬盘中获取，硬盘中的配置文件也是会实时更新的


# 坐标

一个完整的远程配置如下,这样的配置称为坐标，它可以精确的定义一组配置

```json
{
  group : "groupName",
  unit : "unitName",
  version : "1.0-re",
  profile : "dev"
}
```

## 组 group

组的定义是一个归类的概念，类似于是一些有着相似单元的集合，我们可以把它理解为是一个**文件夹**，
或者java里面的**包**，或者maven里面的**group**

## 单元 unit

单元是一个具体到了配置项的定义，从某种意义上来说，一个应用程序就是一个单元，它具体到了一个应用程序

## 版本 version

版本很容易理解，在这个开发阶段处处充满了版本的世界，jrc引入版本的概念并不会觉得太奇怪，这是为了在配置迭代的过程中，
可以同时拥有多个版本的配置，这样的设计是很有好处的。

- 一方面可以在不同的应用场合使用不同的版本文件
- 再一方面也可以对之前的版本文件进行一个备份，而不是选择覆盖

注:版本可以是字符，并不一定非是要数字

## profile

profile 也是一个对不同的配置进行区分的一个控制，看起来它与version的作用是类似的，当然，实际上大部分profile
能做到的，仅仅使用version也能做到，使用profile仅仅是做一个更精细化的控制。

比如即使是同一个版本的配置，也会有着不同，像开发同事的开发机，与服务器的配置，多少会有一些不同的，这个时候我们就
可以指定不同的profile，比如``pro``,``dev``等，当然jrc并没有指定任何的profile，我们完全可以自由定义



# 新增配置
无论是新增配置，或者修改配置，您都可以在jrc所提供的web页面中操作，但是为了避免意外的错误，推荐您在本地编辑器中写好后，
直接复制进去会好一些，因为像一些特殊字符，在web页面中是无法校验的，而像notepad++这种工具，对于yaml的语法是有高亮的


# 删除配置
删除配置是一个敏感的问题，jrc提供了删除操作，但是部分情况是不能删除的，当一个配置仓库被另一个配置仓库依赖时，
是无法删除的，您可以先把相关的依赖取消，就可以删除了。

注意：××删除不可恢复××