package device

/*
* 设备注册接口
* 设备信息缓存器
* */
interface DeviceRegister {
    /*
    * 设备注册
    * */
    fun register(device: Device,handler:(Boolean)->Unit)

    /*
    * 设备注销
    * */
    fun unregister(device: Device,handler:(Boolean)->Unit)

    /*
    * 获取设备
    * */
    fun <T> find(key:T):Device?
}

/*
* 设备注册器的简单实现
* */
open class DeviceRegisterImpl:DeviceRegister{
    override fun <T> find(key: T): Device? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(device: Device,handler:(Boolean)->Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unregister(device: Device,handler:(Boolean)->Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class DeviceRegisterFactory{
    companion object {
        fun getDeviceRegister():DeviceRegisterImpl{
            return DeviceRegisterImpl()
        }
    }
}