// Fetch and display the plant list
function fetchPlants() {
    fetch('/plants')
        .then(res => res.json())
        .then(plants => {
            const tableBody = document.querySelector('table tbody');
            tableBody.innerHTML = ''; // Clear table rows

            plants.forEach(plant => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <td>${plant.commonName}</td>
                    <td>${plant.scientificName}</td>
                    <td>${plant.genusName}</td>
                    <td>${plant.category}</td>
                    <td>${plant.sizeInCm} cm</td>
                    <td>€${plant.approxPrice.toFixed(2)}</td>
                `;

                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching plants:', error));
}

// Modal functionality
const modal = document.getElementById('plant-modal');
const openModalBtn = document.getElementById('open-modal');
const closeModalBtn = document.getElementById('close-modal');

openModalBtn.addEventListener('click', () => {
    modal.style.display = 'flex';
});

closeModalBtn.addEventListener('click', () => {
    modal.style.display = 'none';
});

// Handle form submission to add a new plant
document.getElementById('add-plant-form').addEventListener('submit', (event) => {
    event.preventDefault();

    const formData = new FormData(event.target);
    const plant = Object.fromEntries(formData);

    plant.sizeInCm = parseInt(plant.sizeInCm, 10);
    plant.approxPrice = parseFloat(plant.approxPrice);

    fetch('/addPlant', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(plant),
    })
        .then(res => {
            if (!res.ok) throw new Error('Failed to add plant');
            return res.json();
        })
        .then(() => {
            modal.style.display = 'none'; // Close modal
            fetchPlants(); // Refresh plant list
        })
        .catch(error => console.error('Error adding plant:', error));

    event.target.reset();
});

// Fetch plants when the page loads
fetchPlants();
