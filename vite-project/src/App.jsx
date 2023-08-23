
import "./App.css"
import TableE from "./assets/DataTable/TableE.jsx";
import InsertForm from "./assets/InsertEmployee/InsertForm.jsx";
import InsertForm2 from "./assets/InsertEmployee/InsertForm2.jsx";
import InsertContractPosition from "./assets/InsertContractPosition/InsertContractPosition.jsx";
import Logo from "./assets/Logo/Logo.jsx";
export function App() {
    return (
        <div>
            <Logo/>
            <TableE/>
            <InsertForm/>
            <InsertContractPosition route="saveNewContract" item="contractType" name="contrato" />
            <InsertContractPosition route="saveNewPosition" item="positionType" name="posicion" />
        </div>
    )
}