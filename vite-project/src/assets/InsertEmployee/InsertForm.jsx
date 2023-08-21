import React, { useEffect, useState } from "react";
import "./InsertForm.css"

export default function InsertForm() {
    const [contract, setContract] = useState([])
    const [position, setPosition] = useState([])

    const fetchDataContracts = () => {
        fetch("http://localhost:8080/Assist_Control/getUniqueContracts")
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                setContract(data)})
            .catch((error) => console.error("Error fetching contract types:", error));
    }

    const fetchDataPositions = () => {
        fetch("http://localhost:8080/Assist_Control/getUniquePositions")
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                setPosition(data)})
            .catch((error) => console.error("Error fetching position types:", error));
    }

    useEffect(() => {
        fetchDataContracts();
    }, [])

    useEffect(() => {
        fetchDataPositions();
    }, [])

    const submitForm = (e) => {
        const formData = new FormData(e.target)
        const payload = Object.fromEntries(formData)
        console.log({payload})

        fetch("http://localhost:8080/Assist_Control/addEmployee", {
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
               <div>
               <h2>Agregar empleados</h2>
               {/*<p>Campos requeridos son seguidos de un*/}
               {/*    <strong><span aria-label="required"> *</span></strong>.</p>*/}
               </div>
               <div>
                   <div>
                   <label htmlFor="rut">Rut</label>
                   <input type="text" name="rut" placeholder="Ingrese rut"  pattern="\d{3,8}-[\d|kK]{1}" required/>
                   </div>
                   <div>
                       <label htmlFor="name">Nombre</label>
                       <input type="text" name="name" placeholder="Ingrese nombre" required/>
                   </div>
                   <div>
                       <label htmlFor="surname">Apellido</label>
                       <input type="text" name="surname" placeholder="Ingrese apellido" required/>
                   </div>
                   <div>
                       <label htmlFor="secondSurname">Segundo Apellido</label>
                       <input type="text" name="secondSurname" placeholder="Ingrese segundo apellido"/>
                   </div>
                   <div>
                       <label htmlFor="email">Correo electronico</label>
                       <input type="email" name="email" placeholder="Ingrese correo electronico" required/>
                   </div>
                   <div>
                       <label htmlFor="phoneNumber">Telefono</label>
                       <input type="text" name="phoneNumber" placeholder="Ingrese correo electronico"/>
                   </div>
                   <div>
                       <label htmlFor="birthday">Fecha de nacimiento</label>
                       <input type="date" name="birthday" placeholder="" required/>
                   </div>
                   <div>
                       <label htmlFor="salary">Salario</label>
                       <input type="number" name="salary" min="0" required/>
                   </div>
                   <div>
                       <label htmlFor="nationality">Nacionalidad</label>
                       <select name="nationality">
                           <option>Chile</option>
                           <option>Estados Unidos</option>
                       </select>
                   </div>
                   <div>
                       <label htmlFor="contract">Contrato</label>
                       <select name="contract">
                           <option value="">Seleccione contrato</option>
                           {contract.map((contract) => (
                               <option key="contract" value={contract}>
                                   {contract}
                               </option>
                           ))}
                       </select>
                   </div>
                   <div>
                       <label htmlFor="position">Posicion</label>
                       <select name="position">
                           <option value="">Seleccione posicion</option>
                           {position.map((position) => (
                               <option key="position" value={position}>
                                   {position}
                               </option>
                           ))}
                       </select>
                   </div>
                   <button type="submit">Ingresar</button>
               </div>
           </form>
        </div>
    )
    }

