
import React from "react";
import './SecureConfigUpdate.css'

import { render } from "@testing-library/react";


export default function SecureConfigUpdate() {

    let [configData, setConfigData] = React.useState<Array<any>>([])

    React.useEffect(() => {
        fetch("http://localhost:8111/admin/configurationdata")
            .then(response => response.json())
            .then(configData => setConfigData(configData))
    }, [])





    return (
        <div className="secureConfigUpdate">


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

            <div className="deleteConfigurationData">
                <h2>Delete configuration data</h2>
                <form onSubmit={DeleteConfigurationData}>
                    <p>
                        <label htmlFor='id'>Id:</label>
                        <input id='id' type='number' min={1}/>
                    </p>
                    <button>Delete</button>

                </form>
            </div>

            <div className="configDataTable">
                {configDataToTable()}
            </div>

        </div>
    )



    function configDataToTable(){

        function onClick(configData: any) {

            const showProd  =
                <div className="onClick">
                    <div className="editConfigurationData">
                        <h2>Edit configuration data</h2>
                        <form onSubmit={UpdateConfigurationData}>
                            <p>
                                <label htmlFor='updateid'>Id: </label>
                                <input id='updateid' type='number' min={1} defaultValue={configData.id}/>
                            </p>
                            <p>
                                <label htmlFor='updatename'>Name </label>
                                <input id='updatename' type='text' placeholder={"Enter name"} defaultValue={configData.name}/>
                            </p>
                            <p>
                                <label htmlFor='updateversion'>Version </label>
                                <input id='updateversion' type='text' defaultValue={configData.version}/>
                            </p>
                            <p>
                                <label htmlFor='updatedate'>Date changed(skrote denne?) <br/></label>
                                <input id='updatedate' type='text' defaultValue={configData.date}/>

                            </p>
                            <p>
                                <label>&nbsp;</label> {/* Placeholder */}
                                <button>Submit change</button>
                            </p>
                        </form>
                    </div>

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
                <p><h3>Click tablerow to edit</h3></p>
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

    var id = (document.getElementById('updateid') as HTMLInputElement).value;

    let updateConfigDataAttributes = {
        id:         (document.getElementById('updateid') as HTMLInputElement).value,
        name:  		(document.getElementById('updatename') as HTMLInputElement).value,
        version:	(document.getElementById('updateversion') as HTMLInputElement).value,
        date:   	(document.getElementById('updatedate') as HTMLInputElement).value
    }

    fetch("http://localhost:8111/admin/configurationdata/" +id,
        { method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(updateConfigDataAttributes)})

}

function DeleteConfigurationData() {

    var id = (document.getElementById('id') as HTMLInputElement).value;

    let deleteConfigDataAttributes = {
        id:         (document.getElementById('id') as HTMLInputElement).value}

    fetch("http://localhost:8111/admin/configurationdata/" +id,
        { method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(deleteConfigDataAttributes)})

}
