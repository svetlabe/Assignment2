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
		return (
			<React.Fragment>
				<EnvironmentDetails {...environment} />
				<div className="configDataTable">
					{/*{configDataToTable()}*/}
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
			<h1>{environment.shortname}</h1>
			<li>

			</li>
		</div>
	)
}
/*

function configDataToTable() {

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
function renderTableData() {
	return configdata.map((environment, index) => {
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
*/
