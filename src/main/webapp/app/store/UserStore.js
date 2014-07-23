Ext.define('Westar.store.UserStore', {
    extend: 'Ext.data.Store',
    requires: 'Westar.model.User',    
    model: 'Westar.model.User',
    data: [
		{id: 1, name: '1', sex: '男', age: 11},
		{id: 2, name: '2', sex: '女', age: 11}
	]
});