Ext.define('Westar.store.MenuStore', {
	extend: 'Ext.data.TreeStore',
	autoLoad: true,
	nodeParam: 'pid',
	proxy: {
		type: 'ajax',
		actionMethods: {
			read: 'POST'
		},
		url: 'menu/listPermissionMenu.do'
	},
	reader : {
		type : 'json'
	},
	root: {
		id: '',
		expanded: true
	}
});