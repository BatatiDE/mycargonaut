// src/utils/api.js
export async function postData(url, data) {
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        if (!response.ok) {
            throw new Error(`Error: ${response.status}`);
        }

        // Dynamically parse response based on Content-Type
        const contentType = response.headers.get('Content-Type');
        if (contentType && contentType.includes('application/json')) {
            return await response.json(); // Parse JSON response
        } else if (contentType && contentType.includes('text/plain')) {
            return await response.text(); // Parse text response
        } else {
            throw new Error('Unsupported response type');
        }
    } catch (error) {
        console.error('Error:', error);
        throw error;
    }
}
