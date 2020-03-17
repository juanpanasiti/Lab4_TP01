import React, { Component } from "react";

class TableEnterprise extends Component {
  constructor() {
    super();
    this.setState({
      enterprises: []
    });
  }

  render() {
    return (
      <div>
        <div className="container">
          <table width="50%" align="center">
            <tr>
              {this.state.enterprises.map(enterprise => (
                <td width="50%" key={enterprise.id}>
                  {enterprise.designation}
                </td>
              ))}
            </tr>
          </table>
        </div>
      </div>
    );
  }
}

export default TableEnterprise;
