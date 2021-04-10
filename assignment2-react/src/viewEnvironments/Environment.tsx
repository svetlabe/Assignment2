import React from "react";
import { useParams } from "react-router-dom";
import { RestClient } from "../RestClient"

export default function Environment() {
	
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

				<EnvironmentDetails {...environment} />
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
		<div>
			<h1>{environment.shortName}</h1>
			<div> <b>ID:</b> {environment.id}</div>
			<div> <b> Description:</b> {environment.longName}</div>

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

