
import React from "react";
import './ViewConfigData.css'

import { render } from "@testing-library/react";


export default function ViewConfigData() {

    let [products, setProducts] = React.useState<Array<any>>([])

    React.useEffect(() => {
        fetch("http://localhost:8111/admin/configurationdata/")
            .then(response => response.json())
            .then(products => setProducts(products))
    }, [])





    return (
        <div className="viewConfigData">


            <div className="addProd">
                <h2>Add product</h2>
                <form onSubmit={AddReviewFormMarkup}>
                    <p>
                        <label htmlFor='name'>Name</label>
                        <input type='text' id='name'/>
                    </p>
                    <p>
                        <label htmlFor='price'>Price</label>
                        <input id='price' type='number' min={1}/>
                    </p>
                    <p>
                        <label htmlFor='inStock'>Units in stock</label>
                        <input id='inStock' type='number' min={1}/>

                    </p>
                    <p>
                        <label>&nbsp;</label> {/* Placeholder */}
                        <button>Add product</button>
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

    /*
    function previousMapMethod(){
        {products.map((p, i) => React.createElement(
            "li", {key: i, title:p.id}, `${p.name}, price: ${p.price}, in stock: ${p.instock}`))}
    }
    */

    function changeData(){
        return(
            <div >
                <h2>Change data here</h2>
                Data data data
            </div>
        )
    }

    function configDataToTable(){

        function onClick(product: any) {

            const showProd  =
                <div className="onClick">
                    You clicked on {product.name}, price: {product.price}
                </div>

            render(showProd)
        }

        function renderTableData() {
            return products.map((product, index) => {
                return (
                    <tr onClick={() => onClick(product)} key={product.id}>
                        <td>{product.id}</td>
                        <td>{product.name}</td>
                        <td>{product.price}</td>
                        <td>{product.instock}</td>
                    </tr>

                )
            })

        }

        function renderTableHeader() {
            const test =  ["id", "name", "price", "units in stock"]
            return test.map((key, index) => {
                return <th>{key.toUpperCase()} </th>
            })
        }



        return (
            <div>
                <h2>Products in stock</h2>
                <table id='productTable'>
                    <tbody>
                    {renderTableHeader()}
                    {renderTableData()}
                    </tbody>
                </table>
            </div>
        )



    }

}
function AddReviewFormMarkup() {

    let addProdAttributes = {
        name:  		(document.getElementById('name') as HTMLInputElement).value,
        price:		(document.getElementById('price') as HTMLInputElement).value,
        instock:	(document.getElementById('inStock') as HTMLInputElement).value
    }

    fetch("http://localhost:8110/stock/products" ,
        { method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(addProdAttributes)})


}
