package device

import command.Command
import command.CommandRegisterFactory

/*
* 设备核心接口
* 每个新的设备类型都必须注册其对应的指令集
* */
interface Device{
    /*
    * Command注册方法
    * */
    fun registerCmd(cmd: Command)

    /*
    * 指令注销方式
    * */
    fun unregisterCmd()

    /*
    * 设备注册方法
    * */
    fun registerDevice()

    /*
    * 设备注销
    * */
    fun unregister()
}

/*
* 设备抽象类
* 扩展设备的外部视图
* */
abstract class  AbstractDevice:Device{
    /*
    * 注册设备指令
    * */
    override fun registerCmd(cmd: Command) {
        CommandRegisterFactory.getCommandRegister().register(this,cmd){ res->
            if (res)
                TODO()
            else
                TODO()
        }
    }

    /*
    * 注销设备指令
    * */
    override fun unregisterCmd() {
        CommandRegisterFactory.getCommandRegister().unregister(this){res->
            if(res)
                TODO()
            else
                TODO()
        }
    }

    /*
    * 注册设备
    * */
    override fun registerDevice() {
        DeviceRegisterFactory.getDeviceRegister().register(this){res->
            if(res)
                TODO()
            else
                TODO()
        }
    }

    /*
    * 设备注销
    * */
    override fun unregister() {
        DeviceRegisterFactory.getDeviceRegister().unregister(this){res->
            if(res)
                TODO()
            else
                TODO()
        }
    }

    /*
    * 从设备读取信息
    * */
    abstract fun <T> read():T

    /*
    * 向设备写入信息
    * 提供一个是否发送成功的回调方法
    * */
    abstract fun <T> write(meta:T,handler:(Boolean)->Unit)

    /*
    * 配置设备信息
    * */
    abstract fun <T> config(meta:T)

    /*
    * 获取设备的基本信息
    * */
    abstract fun <T> getInfo():T
}