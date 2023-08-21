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

    //HAce un fetch a la api segun la ruta, y la actualiza cuando esta cambia
    useEffect(() => {
        fetchDataEmployees(route);
    }, [route]);


    useEffect(() => {
        fetchDataContracts();
    }, [])

    useEffect(() => {
        fetchDataPositions();
    }, [])

    const handleButtonClick = () => {
        // Cambia la ruta aquí según tus necesidades
        setRoute("http://localhost:8080/Assist_Control/employees");
    };

    const handleFilterContractClick = (contractType) => {
        setRoute(`http://localhost:8080/Assist_Control/getEmployeesByContract/${contractType}`);
    };



    const handleFilterPositionClick = (positionType) => {
        setRoute(`http://localhost:8080/Assist_Control/getEmployeesByPosition/${positionType}`)
    }

    return (
        <div>
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
                <option value="">Filtrar por posicion</option>
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
                        <td>{employee.age}</td>
                        <td>{employee.contract.contractType}</td>
                        <td>{employee.position.positionType}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

