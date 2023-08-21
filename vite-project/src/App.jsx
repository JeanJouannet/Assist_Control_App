
import "./App.css"
import TableE from "./assets/DataTable/TableE.jsx";
import InsertForm from "./assets/InsertEmployee/InsertForm.jsx";
import InsertContractPosition from "./assets/InsertContractPosition/InsertContractPosition.jsx";

export function App() {
    return (
        <div>
            <TableE/>
            <InsertForm/>
            <InsertContractPosition route="saveNewContract" item="contractType" name="Ingrese nuevo contrato" />
            <InsertContractPosition route="saveNewPosition" item="positionType" name="Ingrese nueva posicion" />
        </div>
    )
}