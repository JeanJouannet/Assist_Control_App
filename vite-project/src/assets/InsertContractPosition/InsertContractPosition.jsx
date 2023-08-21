import React, { useEffect, useState } from "react";
import "./InsertContractPosition.css";

export default function InsertContractPosition({route, item, name}){

    const submitForm = (e) => {
        e.preventDefault()
        const formData = new FormData(e.target)
        const payload = Object.fromEntries(formData)
        console.log({payload})

        fetch(`http://localhost:8080/Assist_Control/${route}`, {
            method: 'POST',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((res) => res.json()).catch((err) => {
            console.log(err.message);
        });
    }

    return(
        <div>
            <form onSubmit={submitForm}>
                 <h2>Agregar Posicion</h2>
                <div>
                    <label htmlFor={item}>{name}</label>
                    <input type="text" key={item} name={item} placeholder={name} required/>
                </div>
                <div>
                    <button type="submit">Agregar nuevo contrato</button>
                </div>
            </form>
        </div>)
}