
import React from "react";
import './ViewConfigData.css'

import { render } from "@testing-library/react";


export default function ViewConfigData() {

    let [configData, setConfigData] = React.useState<Array<any>>([])

    React.useEffect(() => {
        fetch("http://localhost:8111/admin/configurationdata")
            .then(response => response.json())
            .then(configData => setConfigData(configData))
    }, [])





    return (
        <div className="viewConfigData">


            <div className="addConfigurationData">
                <h2>Add configuration data</h2>
                <form onSubmit={AddConfigurationData}>
                    <p>
                        <label htmlFor='name'>Name</label>
                        <input id='name' type='text'/>
                    </p>
                    <p>
                        <label htmlFor='version'>Version</label>
                        <input id='version' type='text' min={1}/>
                    </p>
                    <p>
                        <label htmlFor='date'>Date changed</label>
                        <input id='date' type='text' min={1}/>

                    </p>
                    <p>
                        <label>&nbsp;</label> {/* Placeholder */}
                        <button>Add to database</button>
                    </p>
                </form>
            </div>


            <div className="inStockTable">
                {configDataToTable()}
            </div>
            <div className="changeData">
                {changeData()}
            </div>
        </div>
    )



    function changeData(){
        return(
            <div >
                <h2>Change data here</h2>
                Data data data
            </div>
        )
    }

    function configDataToTable(){

        function onClick(configData: any) {

            const showProd  =
                <div className="onClick">
                    You clicked on {configData.name}, date changed: {configData.price}
                </div>

            render(showProd)

        }



        function renderTableData() {
            return configData.map((configData, index) => {
                return (
                    <tr onClick={() => onClick(configData)} key={configData.id}>
                        <td>{configData.id}</td>
                        <td>{configData.name}</td>
                        <td>{configData.version}</td>
                        <td>{configData.date}</td>
                    </tr>

                )
            })

        }

        function renderTableHeader() {
            const test =  ["id", "name", "version", "date changed"]
            return test.map((key, index) => {
                return <th>{key.toUpperCase()} </th>
            })
        }



        return (
            <div>
                <h2>Configuration Data</h2>
                <table id="configDataTable">
                    <tbody>
                    {renderTableHeader()}
                    {renderTableData()}
                    </tbody>
                </table>
            </div>
        )



    }

}
function AddConfigurationData() {

    let addConfigDataAttributes = {
        name:  		(document.getElementById('name') as HTMLInputElement).value,
        version:	(document.getElementById('version') as HTMLInputElement).value,
        date:   	(document.getElementById('date') as HTMLInputElement).value
    }

    fetch("http://localhost:8111/admin/configurationdata" ,
        { method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(addConfigDataAttributes)})

}

function UpdateConfigurationData() {

    let updateConfigDataAttributes = {
        name:  		(document.getElementById('name') as HTMLInputElement).value,
        version:	(document.getElementById('version') as HTMLInputElement).value,
        date:   	(document.getElementById('date') as HTMLInputElement).value
    }

    fetch("http://localhost:8111/admin/configurationdata" ,
        { method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(updateConfigDataAttributes)})

}
