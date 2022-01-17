import mongoose from 'mongoose'

function carros(){
    let schema = mongoose.Schema({
        nome:{
            type: String,
            require: true
        },
        marca:{
            type: String,
            require: true,
            unique: true
        },
        placa:{
            type: String,
            require: true
        },
        ano:{
            type: String,
            require: true
        }
    })
    return mongoose.model("Carro",schema)
}

export default carros()