
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

            <div className="editConfigurationData">
                <h2>Edit configuration data</h2>
                <form onSubmit={UpdateConfigurationData}>
                    <p>
                        <label htmlFor='id'>Enter id:</label>
                        <input id='id' type='number'/>
                    </p>
                    <p>
                        <label htmlFor='updatename'>New name</label>
                        <input id='updatename' type='text'/>
                    </p>
                    <p>
                        <label htmlFor='updateversion'>New version</label>
                        <input id='updateversion' type='text' min={1}/>
                    </p>
                    <p>
                        <label htmlFor='updatedate'>Date changed(skrote denne?)</label>
                        <input id='updatedate' type='text' min={1}/>

                    </p>
                    <p>
                        <label>&nbsp;</label> {/* Placeholder */}
                        <button>Submit change</button>
                    </p>
                </form>
            </div>


            <div className="inStockTable">
                {configDataToTable()}
            </div>

        </div>
    )



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

    var id = (document.getElementById('id') as HTMLInputElement).value;

    let updateConfigDataAttributes = {
        name:  		(document.getElementById('updatename') as HTMLInputElement).value,
        version:	(document.getElementById('updateversion') as HTMLInputElement).value,
        date:   	(document.getElementById('updatedate') as HTMLInputElement).value
    }

    fetch("http://localhost:8111/admin/configurationdata/" +id,
        { method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(updateConfigDataAttributes)})

}
