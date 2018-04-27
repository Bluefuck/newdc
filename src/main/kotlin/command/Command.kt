package command

import device.Device

abstract class AbstractCommand(private val device: Device):Command {
    protected abstract var cmdInfo:Any?

    override fun getInfo(): Any? {
        return cmdInfo
    }

    abstract fun setArgs(meta:Any?)
}

interface Command{

    fun getInfo():Any?

    fun execute()
}

/*
* 设备指令注册表
* */
interface CommandRegister{

    /*
    * 注册指令
    * */
    fun register(device: Device,command:Command,handler:(Boolean)->Unit)

    /*
    * 支持泛型参数的注册
    * */
    fun <T> register(device: Device,command: Command,t1:T,handler:(Boolean)->Unit)

    /*
    * 注销指令
    * */
    fun unregister(device: Device,handler:(Boolean)->Unit)

    /*
    * 获取设备指令集
    * */
    fun findDeivce(device: Device):Command
}

/*
* 设备指令注册器的简单实现
* */
open class CommandRegisterImpl:CommandRegister{
    override fun findDeivce(device: Device): Command {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> register(device: Device,command: Command, t1: T, handler: (Boolean) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(device: Device, command: Command, handler: (Boolean) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unregister(device: Device, handler: (Boolean) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

/*
* 指令注册器工厂类
* */
open class CommandRegisterFactory{
    companion object {
        open fun getCommandRegister(): CommandRegisterImpl {
            return CommandRegisterImpl()
        }
    }
}