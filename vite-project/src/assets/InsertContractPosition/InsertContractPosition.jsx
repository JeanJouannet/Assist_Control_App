import React, { useEffect, useState } from "react";
import "./InsertContractPosition.css";

export default function InsertContractPosition({route, item, name}){
    const placeHolder = `Ingrese ${name}`
    const submitForm = (e) => {
        // e.preventDefault()
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
        <div className="container-insertContractPosition">
            <form onSubmit={submitForm}>
                 <h2>Agregar {name}</h2>
                <div>
                    <label htmlFor={item}>Ingrese {name}</label>
                    <input type="text" key={item} name={item} placeholder={placeHolder} required/>
                </div>
                <div>
                    <button type="submit">Agregar {name}</button>
                </div>
            </form>
        </div>)
}