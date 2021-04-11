import React from "react";
import {Link, NavLink, useParams} from "react-router-dom";
import { RestClient } from "../RestClient"
import "./ListEnvironments.css"
import AddConfigurationToEnvironment from "./AddConfigToEnvironment";



export default function AdminEnvironment() {
	
	let { id } : any = useParams();
	let [environment, setEnvironment] = React.useState<any>(undefined)

	React.useEffect(() => {
		RestClient.getEnvironment(id)
		          .then(environment => setEnvironment(environment))
				  .catch((err: any) => alert(err))
	}, [])

	if (environment) {
		let configData = environment.configurationData;
		return (
			<React.Fragment>
				<p><Link to={"/dashboard"}> BACK TO DASHBOARD </Link></p>

				<EnvironmentDetails {...environment} />
				<AddConfigurationToEnvironment/>
				<div className="configDataTable">
					{configDataToTable(configData)}


				</div>
			</React.Fragment>
		)
	} else {
		return <p>...</p>
	}
}

function EnvironmentDetails(environment: any) {
	return (
		<div className= "textForEnv">
			<h1>{environment.shortName}</h1>
			<div className= "singleEnv" >
				<div> <b>ID:</b> {environment.id}</div>
				<div> <b> Description:</b> {environment.longName}</div>
			</div>


		</div>
	)
}


function configDataToTable(configurationData : any) {

	return (
		<div>
			<h2>Configuration Data</h2>
			<p><h3></h3></p>
			<table id="configDataTable">
				<tbody>
				{renderTableHeader()}
				{renderTableData(configurationData)}
				</tbody>
			</table>
		</div>
	)

}
function renderTableData(configData : any) {
	return configData.map((configData:any, index: any) => {
		return (

			<tr >
				<td>{configData.id}</td>
				<td>{configData.name}</td>
				<td>{configData.version}</td>
				<td>{configData.date}</td>
			</tr>

		)
	})


}
function renderTableHeader() {
	const test = ["id","name", "version", "date changed"]
	return test.map((key, index) => {
		return <th>{key.toUpperCase()} </th>
	})
}

