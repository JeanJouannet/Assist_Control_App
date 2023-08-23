import React, { useEffect, useState } from "react";
import "./TableE.css";

export default function TableE() {
    const [employeeData, setEmployeeData] = useState(null);
    const [contractType, setContractType] = useState([])
    const [positionType, setPositionType] = useState([])
    const [route, setRoute] = useState("");

    const fetchDataEmployees = (newRoute) => {
        fetch(newRoute)
            .then((response) => response.json())
            .then((data) => setEmployeeData(data));
    };

    const fetchDataContracts = () => {
        fetch("http://localhost:8080/Assist_Control/getUniqueContracts")
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                setContractType(data)})
            .catch((error) => console.error("Error fetching contract types:", error));
    }

    const fetchDataPositions = () => {
        fetch("http://localhost:8080/Assist_Control/getUniquePositions")
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                setPositionType(data)})
            .catch((error) => console.error("Error fetching position types:", error));
    }

    useEffect(() => {
        fetchDataEmployees(route);
    }, [route]);


    useEffect(() => {
        fetchDataContracts();
    }, [])

    useEffect(() => {
        fetchDataPositions();
    }, [])

    const FunRemove=((rut)=>{
        if(window.confirm("Desea borrar empleado?")){
            fetch("http://localhost:8080/Assist_Control/deleteEmployeeByRut/"+rut,
                {method:"DELETE"}).then(()=>{

                window.location.reload();

            }).catch((err)=>{
                console.log(err.message)
            })
        }

    })


    const handleButtonClick = () => {
        setRoute("http://localhost:8080/Assist_Control/employees");
    };

    const handleFilterContractClick = (contractType) => {
        setRoute(`http://localhost:8080/Assist_Control/getEmployeesByContract/${contractType}`);
    };



    const handleFilterPositionClick = (positionType) => {
        setRoute(`http://localhost:8080/Assist_Control/getEmployeesByPosition/${positionType}`)
    }

    return (
        <div className="container-table">
            <h2>Mostrar empleados</h2>
            <button onClick={handleButtonClick}>Buscar todos los empleados</button>

                <span>Filtrar por contrato: </span>
                <select onChange={(e) => handleFilterContractClick(e.target.value)}>
                    <option value="">Filtrar por contrato</option>
                    {contractType.map((contract) => (
                        <option value={contract}>
                            {contract}
                        </option>
                    ))}
                </select>

            <span>Filtrar por posicion: </span>
            <select onChange={(p) => handleFilterPositionClick(p.target.value)}>
                <option>Filtrar por posicion</option>
                {positionType.map((position) => (
                    <option value={position}>
                        {position}
                    </option>
                ))}
            </select>
            <table>
                <thead>
                <tr>
                    <th>Rut</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Segundo Apellido</th>
                    <th>Email</th>
                    <th>Telefono</th>
                    <th>Nacionalidad</th>
                    <th>Salario</th>
                    <th>Edad</th>
                    <th>Tipo de contrato</th>
                    <th>Posicion</th>
                </tr>
                </thead>
                <tbody>
                {employeeData?.map((employee) => (
                    <tr>
                        <td>{employee.rut}</td>
                        <td>{employee.name}</td>
                        <td>{employee.surname}</td>
                        <td>{employee.secondSurname}</td>
                        <td>{employee.email}</td>
                        <td>{employee.phoneNumber}</td>
                        <td>{employee.nationality}</td>
                        <td>{employee.salary}</td>
                        <td>{employee.age} años</td>
                        <td>{employee.contract.contractType}</td>
                        <td>{employee.position.positionType}</td>
                        <td><button onClick={()=> {FunRemove(employee.rut)}}>Borrar</button></td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

